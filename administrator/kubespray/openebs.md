# Storage - OpenEBS

```shell
helm repo add openebs https://openebs.github.io/charts
```

```shell
helm install openebs --namespace openebs openebs/openebs --create-namespace
```

Changing the default StorageClass
```shell
kubectl get storageclass
```

Mark the default StorageClass as non-default:
```shell
kubectl patch storageclass standard -p '{"metadata": {"annotations":{"storageclass.kubernetes.io/is-default-class":"false"}}}'
```

Mark a StorageClass as default:
```shell
kubectl patch storageclass gold -p '{"metadata": {"annotations":{"storageclass.kubernetes.io/is-default-class":"true"}}}'


```



# testing
```shell
kubectl apply -f https://openebs.github.io/charts/examples/local-hostpath/local-hostpath-pvc.yaml
kubectl apply -f https://openebs.github.io/charts/examples/local-hostpath/local-hostpath-pod.yaml
```