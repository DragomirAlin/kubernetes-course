# Openstack Cloud Provider

1. Enable the new external cloud provider in group_vars/all/all.yml:
```shell
cloud_provider: external
external_cloud_provider: openstack
```

2. Enable Cinder CSI in group_vars/all/openstack.yml:
```shell
cinder_csi_enabled: true
```

3. Enable topology support (optional), if your openstack provider has custom Zone names you can override the default "nova" zone by setting the variable cinder_topology_zones
```shell
cinder_topology: true
```

4. If you are using OpenStack loadbalancer(s) replace the openstack_lbaas_subnet_id with the new external_openstack_lbaas_subnet_id. Note The new cloud provider is using Octavia instead of Neutron LBaaS by default!

5. Enable 3 feature gates to allow migration of all volumes and storage classes (if you have any feature gates already set just add the 3 listed below):
```shell
kube_feature_gates:
- CSIMigration=true
- CSIMigrationOpenStack=true
- ExpandCSIVolumes=true
```

run
```shell
ansible-playbook -i inventory/mycluster/hosts.yml --become --become-user=root cluster.yml
```

[openstack provider docs](https://github.com/kubernetes-sigs/kubespray/blob/master/docs/openstack.md#:~:text=To%20deploy%20Kubespray%20on%20OpenStack,%2Fyour%2Fopenstack%2Drc%20.)