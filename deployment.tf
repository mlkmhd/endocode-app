provider "helm" {
  kubernetes {
    config_path = "~/.kube/config"
  }
}

resource "helm_release" "demo-app" {
  name       = "endocode-app"

  chart      = "./helm-chart"

  set {
    name  = "terminationGracePeriodSeconds"
    value = "30"
  }
}
