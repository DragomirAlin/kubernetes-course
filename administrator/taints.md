# Taints
Taints are a Kubernetes node property that enable nodes to repel certain pods. Tolerations are a Kubernetes pod property that allow a pod to be scheduled on a node with a matching taint.

You can use kubectl describe node <nodename> to check taints.

```yaml
kubectl describe node masternode
Name:               masternode
Roles:              master
Labels:             beta.kubernetes.io/arch=amd64
                    beta.kubernetes.io/os=linux
                    kubernetes.io/arch=amd64
                    kubernetes.io/hostname=ip-10-0-0-115
                    kubernetes.io/os=linux
                    node-role.kubernetes.io/master=
Annotations:        kubeadm.alpha.kubernetes.io/cri-socket: /var/run/dockershim.sock
                    node.alpha.kubernetes.io/ttl: 0
                    projectcalico.org/IPv4Address: 10.0.0.115/24
                    projectcalico.org/IPv4IPIPTunnelAddr: 192.168.217.0
                    volumes.kubernetes.io/controller-managed-attach-detach: true
CreationTimestamp:  Thu, 18 Jun 2020 10:21:48 +0530
Taints:             node-role.kubernetes.io/master:NoSchedule
```

The node controller automatically taints a Node when certain conditions are true. The following taints are built in:

`node.kubernetes.io/not-ready`: Node is not ready. This corresponds to the NodeCondition Ready being "False".

`node.kubernetes.io/unreachable`: Node is unreachable from the node controller. This corresponds to the NodeCondition Ready being "Unknown".

`node.kubernetes.io/out-of-disk`: Node becomes out of disk.

`node.kubernetes.io/memory-pressure`: Node has memory pressure.

`node.kubernetes.io/disk-pressure`: Node has disk pressure.

`node.kubernetes.io/network-unavailable`: Node's network is unavailable.

`node.kubernetes.io/unschedulable`: Node is unschedulable.

`node.cloudprovider.kubernetes.io/uninitialized`: When the kubelet is started with "external" cloud provider, this taint is set on a node to mark it as unusable. After a controller from the cloud-controller-manager initializes this node, the kubelet removes this taint.

Along with above a special taint `node-role.kubernetes.io/master:NoSchedule` is added by default to master nodes.

The error typically comes if there is a taint on nodes for which you don't have corresponding toleration in pod spec.

### Real cases:

#### 1. node3 was down
```sh
kubectl describe node node3
```
```yaml
Taints: node.cloudprovider.kubernetes.io/uninitialized=true:NoSchedule
```
I used this command to remove the taint
```sh
kubectl taint node node3 node.cloudprovider.kubernetes.io/uninitialized=true:NoSchedule-
```

### References
[https://blog.kubecost.com/blog/kubernetes-taints/](https://blog.kubecost.com/blog/kubernetes-taints/)