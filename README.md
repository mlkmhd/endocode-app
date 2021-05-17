# Getting Started

## Build & Run the app in Old Style

this is a java application and you can build it with the following code:

```bash
$ mvn clean package
$ mv target/*.jar target/app.jar
$ java -jar target/app.jar
```

## Build & Run in Docker

```bash
$ docker build . --no-cache endocode-app 
$ docker run -p 8080:8080 -d endocode-app 
```

## Deploy On Kubernetes

you can deploy this application into the kubernetes cluster by the following command:

```bash
$ helm install endocode ./helm-chart
```
you can configure the values of `terminationGracePeriodSeconds` and `image` in the `values.yaml` file.

you can also simply deploy using terraform:

```bash
$ terraform init
$ terraform apply
```

## Jenkins Pipeline

you can use a predefiend jenkins pipeline file. the `Jenkinsfile` will automcatically build the app then push it to docker hub and then deploy it to kubernetes using terraform. all the things that you need to do is only running your jenkins and add importing this project into that.

## Shipping logs to ELK

first you need to deploy the filebeat to kubernetes. it will automatically collect all logs from all containers and will ship them into the ELK. you need to change the `filebeat-kubernetes.yaml` file and set `ELASTICSEARCH_HOST` and `ELASTICSEARCH_PORT` with your desiered values.
the you can deploy it into the kubernetes by the following command:

```bash
$ kubectl create -f filebeat-kubernetes.yaml
```

