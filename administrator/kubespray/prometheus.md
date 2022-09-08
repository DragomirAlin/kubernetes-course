# Prometheus
Prometheus is a monitoring system and time series database. It collects metrics from configured targets at given intervals, evaluates rule expressions, displays the results, and can trigger alerts if some condition is observed to be true.

![Prometheus](/assets/img/prometheus.png)

```
kubectl create namespace monitor
```

1. Create a Cluster Role 
```bash
kubectl create -f clusterRole.yaml
```

2. Create a Config Map To Externalize Prometheus Configurations
```bash
kubectl create -f config-map.yaml
```

3. Create deployment
```bash
kubectl create  -f prometheus-deployment.yaml 
```

4. Use Kubectl port forwarding
```bash
kubectl port-forward <podname> 8080:9090 -n monitor
```

5. Access Prometheus UI
`http://localhost:8080`

