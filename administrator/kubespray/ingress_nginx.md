## Installation Guide

```bash
ingress_nginx_enabled: true
ingress_nginx_host_network: true
ingress_publish_status_address: ""
```

```bash
ansible-playbook -i inventory/mycluster/hosts.yml --become cluster.yml --tags apps,ingress-nginx,ingress-controller
```