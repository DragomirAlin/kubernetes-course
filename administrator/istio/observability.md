# Observability
Envoy proxies will send off telemetry and other data that you can use to visualize the traffic in the mesh.

## 1. Kiali
Kiali is a console for Istio service mesh. Kiali can be quickly installed as an Istio add-on, or trusted as a part of your production environment.

### 1.1. Installation
```bash
$  kubectl apply -f samples/addons
$  kubectl -n istio-system get pods -l app=kiali
```

### 1.2. Access Kiali Dashboard
```bash
$ istioctl dashboard kiali
$ istioctl dashboard grafana
$ istioctl dashboard jaeger
```

### 

## Production-ready Istio
1. Install Kiali Server/Operator [helm charts](https://github.com/kiali/helm-charts), config auth and expose [docs](https://kiali.io/docs/configuration/authentication/)

