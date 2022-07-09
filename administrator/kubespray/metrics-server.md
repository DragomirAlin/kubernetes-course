# What is metrics-server ?
Metrics Server is a cluster-wide aggregator of resource usage data. It collects metrics like CPU or memory consumption for containers or nodes, from the Summary API, exposed by Kubelet on each node. If your kubernetes is formed by kube-up.sh script then you probably have a metrics-server by default. But if you use kubespray or kops to build a production ready k8s cluster, then you need to deploy separately.

