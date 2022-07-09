# Deploy Kubernetes Cluster with Kubespray

1. Create Linux Users on all hosts:
```bash
sudo useradd <name>
```

2. Set `NOPASSWD` to user:
```bash
sudo nano /etc/sudoers
```
```
alin    ALL=(ALL) NOPASSWD:ALL
```
Restart nodes

3. Generate keypair:
```bash
ssh-keygen -t rsa
```

4. Copy it on nodes:
```bash
ssh-copy-id <ip>
```

5. Clone Kubespray:
```bash
git clone https://github.com/kubernetes-sigs/kubespray.git
```
```bash
cd kubespray
```

6. Install requirements:
```bash
sudo pip install -r requirements.txt
```

7. Build our configuration:
```bash
cp -rfp inventory/sample inventory/mycluster
```

8. Declare a variable that contains all the IP addresses:
```bash
declare -a IPS=(10.1.1.101 10.1.1.102 10.1.1.103)
```

9. Use var to build a new config file:
```bash
CONFIG_FILE=inventory/mycluster/hosts.yml python3 contrib/inventory_builder/inventory.py ${IPS[@]}
```

```bash
DEBUG: Adding group all
DEBUG: Adding group kube_control_plane
DEBUG: Adding group kube_node
DEBUG: Adding group etcd
DEBUG: Adding group k8s_cluster
DEBUG: Adding group calico_rr
DEBUG: adding host node1 to group all
DEBUG: adding host node2 to group all
DEBUG: adding host node3 to group all
DEBUG: adding host node1 to group etcd
DEBUG: adding host node2 to group etcd
DEBUG: adding host node3 to group etcd
DEBUG: adding host node1 to group kube_control_plane
DEBUG: adding host node2 to group kube_control_plane
DEBUG: adding host node1 to group kube_node
DEBUG: adding host node2 to group kube_node
DEBUG: adding host node3 to group kube_node
```

10.  Review hosts:
```bash
nano inventory/mycluster/hosts.yml
nano inventory/mycluster/group_vars/all/all.yml
nano inventory/mycluster/group_vars/k8s_cluster/k8s_cluster.yml
```

11. Deploy Cluster with Ansible:
```bash
ansible-playbook -i inventory/mycluster/hosts.yml --become --become-user=root cluster.yml
```


For modification
```bash
ansible-playbook -i inventory/mycluster/hosts.yml --become cluster.yml --tags file,file,file
```


[Ansible](https://github.com/kubernetes-sigs/kubespray/blob/master/docs/ansible.md#ansible-tags)