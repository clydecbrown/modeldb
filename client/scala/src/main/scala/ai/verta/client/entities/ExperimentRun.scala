package ai.verta.client.entities

import java.io._
import java.time.{Instant, LocalDateTime}
import java.util.TimeZone

import ai.verta.client.entities.subobjects._
import ai.verta.client.entities.utils.KVHandler
import ai.verta.swagger._public.modeldb.model._
import ai.verta.swagger.client.ClientSet

import scala.collection.mutable
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext}
import scala.util.{Failure, Success, Try}

class ExperimentRun(clientSet: ClientSet, val expt: Experiment, val run: ModeldbExperimentRun) extends Taggable {
  def tags()(implicit ec: ExecutionContext) = new Tags(clientSet, ec, this)

  override def getTags()(implicit ec: ExecutionContext): Try[List[String]] = {
    clientSet.experimentRunService.getExperimentRunTags(run.id.get)
      .map(r => r.tags.getOrElse(Nil))
  }

  override def delTags(tags: List[String])(implicit ec: ExecutionContext): Try[Unit] = {
    clientSet.experimentRunService.deleteExperimentRunTags(ModeldbDeleteExperimentRunTags(
      id = run.id,
      tags = Some(tags)
    ))
      .map(_ => {})
  }

  override def addTags(tags: List[String])(implicit ec: ExecutionContext): Try[Unit] = {
    clientSet.experimentRunService.addExperimentRunTags(ModeldbAddExperimentRunTags(
      id = run.id,
      tags = Some(tags)
    ))
      .map(_ => {})
  }

  // TODO: add overwrite
  def hyperparameters()(implicit ec: ExecutionContext) = new Hyperparameters(clientSet, ec, this)

  def logHyperparameters(vals: Map[String, Any])(implicit ec: ExecutionContext): Try[Unit] = {
    val valsList = utils.KVHandler.mapToKVList(vals)
    if (valsList.isFailure) Failure(valsList.failed.get) else
      clientSet.experimentRunService.logHyperparameters(ModeldbLogHyperparameters(
        id = run.id,
        hyperparameters = valsList.toOption
      )).map(_ => {})
  }

  def logHyperparameter(key: String, value: Any)(implicit ec: ExecutionContext) =
    logHyperparameters(Map(key -> value))

  def getHyperparameters()(implicit ec: ExecutionContext): Try[Map[String, Any]] = {
    clientSet.experimentRunService.getHyperparameters(
      id = run.id.get
    )
      .flatMap(r => {
        if (r.hyperparameters.isEmpty)
          Success(Map[String, Any]())
        else
          utils.KVHandler.kvListToMap(r.hyperparameters.get)
      })
  }

  def getHyperparameter(key: String)(implicit ec: ExecutionContext) =
    getHyperparameters().map(_.get(key))

  // TODO: add overwrite
  def metrics()(implicit ec: ExecutionContext) = new Metrics(clientSet, ec, this)

  def logMetrics(vals: Map[String, Any])(implicit ec: ExecutionContext): Try[Unit] = {
    val valsList = utils.KVHandler.mapToKVList(vals)
    if (valsList.isFailure) Failure(valsList.failed.get) else
      clientSet.experimentRunService.logMetrics(ModeldbLogMetrics(
        id = run.id,
        metrics = valsList.toOption
      )).map(_ => {})
  }

  def logMetric(key: String, value: Any)(implicit ec: ExecutionContext) =
    logMetrics(Map(key -> value))

  def getMetrics()(implicit ec: ExecutionContext): Try[Map[String, Any]] = {
    clientSet.experimentRunService.getMetrics(
      id = run.id.get
    )
      .flatMap(r => {
        if (r.metrics.isEmpty)
          Success(Map[String, Any]())
        else
          utils.KVHandler.kvListToMap(r.metrics.get)
      })
  }

  def getMetric(key: String)(implicit ec: ExecutionContext) =
    getMetrics().map(_.get(key))

  // TODO: add overwrite
  def attributes()(implicit ec: ExecutionContext) = new Attributes(clientSet, ec, this)

  def logAttributes(vals: Map[String, Any])(implicit ec: ExecutionContext): Try[Unit] = {
    val valsList = utils.KVHandler.mapToKVList(vals)
    if (valsList.isFailure) Failure(valsList.failed.get) else
      clientSet.experimentRunService.logAttributes(ModeldbLogAttributes(
        id = run.id,
        attributes = valsList.toOption
      )).map(_ => {})
  }

  def logAttribute(key: String, value: Any)(implicit ec: ExecutionContext) =
    logAttributes(Map(key -> value))

  def getAttributes(keys: List[String] = Nil)(implicit ec: ExecutionContext): Try[Map[String, Any]] = {
    clientSet.experimentRunService.getExperimentRunAttributes(
      id = run.id.get,
      attribute_keys = keys,
      get_all = keys.isEmpty
    )
      .flatMap(r => {
        if (r.attributes.isEmpty)
          Success(Map[String, Any]())
        else
          utils.KVHandler.kvListToMap(r.attributes.get)
      })
  }

  def getAttribute(key: String)(implicit ec: ExecutionContext) =
    getAttributes(List(key)).map(_.get(key))

  def logObservation(key: String, value: Any, timestamp: LocalDateTime = null)(implicit ec: ExecutionContext) = {
    val ts = if (timestamp == null) LocalDateTime.now() else timestamp

    val convertedValue = KVHandler.convertValue(value, s"unknown type for observation ${key}")
    convertedValue.flatMap(newValue => {
      clientSet.experimentRunService.logObservation(ModeldbLogObservation(
        id = run.id,
        observation = Some(ModeldbObservation(
          attribute = Some(CommonKeyValue(
            key = Some(key),
            value = Some(newValue)
          )),
          timestamp = Some(ts.atZone(TimeZone.getTimeZone("UTC").toZoneId).toInstant.toEpochMilli.toString)
        ))
      ))
    })
      .map(_ => {})
  }

  def getObservation(key: String)(implicit ec: ExecutionContext) = {
    clientSet.experimentRunService.getObservations(id = run.id.get, observation_key = key)
      .map(res => {
        res.observations.map(obs => {
          obs.map(o => {
            (
              LocalDateTime.ofInstant(Instant.ofEpochMilli(o.timestamp.get.toLong), TimeZone.getTimeZone("UTC").toZoneId),
              KVHandler.convertValue(o.attribute.get.value.get, s"unknown type for observation ${key}").get
            )
          })
        }).getOrElse(Nil)
      })
  }

  def getObservations()(implicit ec: ExecutionContext) = {
    clientSet.experimentRunService.getExperimentRunById(run.id.get)
      .map(runResp => {
        val observations = runResp.experiment_run.get.observations
        val obsMap = new mutable.HashMap[String, List[(LocalDateTime, Any)]]()
        observations.get.foreach(o => {
          val ts = LocalDateTime.ofInstant(Instant.ofEpochMilli(o.timestamp.get.toLong), TimeZone.getTimeZone("UTC").toZoneId)
          val key = o.attribute.get.key.get
          val value = KVHandler.convertValue(o.attribute.get.value.get, s"unknown type for observation $key")
          obsMap.update(key, (ts, value) :: obsMap.getOrElse(key, Nil))
        })
        obsMap.map(el => {
          (el._1, el._2.sortBy(_._1.atZone(TimeZone.getTimeZone("UTC").toZoneId).toInstant().toEpochMilli))
        }).toMap
      })
  }

  def logArtifactObj[T <: Serializable](key: String, obj: T)(implicit ec: ExecutionContext) = {
    val arr = new ByteArrayOutputStream()
    val stream = new ObjectOutputStream(arr)
    stream.writeObject(obj)
    stream.close
    logArtifact(key, new ByteArrayInputStream(arr.toByteArray))
  }

  def logArtifact(key: String, stream: InputStream)(implicit ec: ExecutionContext) = {
    clientSet.experimentRunService.getUrlForArtifact(ModeldbGetUrlForArtifact(
      id = run.id,
      key = Some(key),
      method = Some("PUT"),
      artifact_type = Some(ArtifactTypeEnumArtifactType.BLOB)
    ))
      .map(r => {
        Await.result(clientSet.client.requestRaw("PUT", r.url.get, null, stream), Duration.Inf)
      })
      .map(_ => {})
  }

  def getArtifactObj[T <: Serializable](key: String)(implicit ec: ExecutionContext) = {
    getArtifact(key)
      .map(stream => {
        val arr = new ByteArrayInputStream(stream.toByteArray)
        val stream2 = new ObjectInputStream(arr)
        val obj = stream2.readObject().asInstanceOf[T]
        stream2.close
        stream.close
        obj
      })
  }

  def getArtifact(key: String)(implicit ec: ExecutionContext) = {
    clientSet.experimentRunService.getUrlForArtifact(ModeldbGetUrlForArtifact(
      id = run.id,
      key = Some(key),
      method = Some("GET"),
      artifact_type = Some(ArtifactTypeEnumArtifactType.BLOB)
    ))
      .flatMap(r => {
        Await.result(
          clientSet.client.requestRaw("GET", r.url.get, null, null)
            .map(resp => {
              resp match {
                case Success(response) => {
                  val arr = new ByteArrayOutputStream()
                  arr.write(response.getBytes, 0, response.length)
                  Success(arr)
                }
                case Failure(x) => Failure(x)
              }
            }),
          Duration.Inf
        )
      })
  }
}
