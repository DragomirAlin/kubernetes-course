# MicroK8s Cluster

```bash
sudo snap install microk8s --classic --channel=1.19/stable
```

### on the initial node
```bash
microk8s add-node
```

### enable coreDNS
```bash
microk8s enable dns
```