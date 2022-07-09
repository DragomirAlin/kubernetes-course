# Argo CD

## Helm Chart

[bitnami/argo-cd](https://bitnami.com/stack/argo-cd/helm)


```shell
helm upgrade --install argocd bitnami/argo-cd -f values.yaml
```


## Issue

Adding another cause for the Too many redirects error.

While working with ingress-nginx as an ingress controller in front of some k8s services.

One of the services (ArgoCD in my case) handled TLS termination by itself and always redirects HTTP requests to HTTPS.

The problem is that the nginx ingress controller also handled TLS termination and communicates with the backend service with HTTP then the result is that the ArgoCD's server always responding with a redirects to HTTPS which is the cause for the multiple redirects.

Any attempts to pass relevant values to the ingress annotations below will not help:

```shell
annotations:
  nginx.ingress.kubernetes.io/ssl-redirect: false/true
  nginx.ingress.kubernetes.io/backend-protocol: "HTTP"/"HTTPS"
```

The solution was to ensure that the service doesn't handle TLS by passing --insecure flag to the argocd-server deployment:

```shell
spec:
  template:
    spec:
      containers:
      - name: argocd-server
        command:
        - argocd-server
        - --repo-server
        - argocd-repo-server:8081
        - --insecure # <-- Here
```

[stackoverflow source](https://stackoverflow.com/questions/49856754/nginx-ingress-too-many-redirects-when-force-ssl-is-enabled)
