# Cert manager

# Cert manager deployment
cert_manager_enabled: true

[Kubernetes TLS Root CA Certificate/Key Secret](https://kubespray.io/#/docs/cert_manager?id=kubernetes-tls-root-ca-certificatekey-secret)

```bash
ansible-playbook -i inventory/mycluster/hosts.yml --become cluster.yml --tags apps,cert-manager
```

### Create tls secrets
Cloudflare -> SSL/TLS -> Client Certificates -> Create Certificates

Download key and crt

kubectl create secret tls cloudflare-tls --key <key> --cert <crt>

Use `cloudflare-tls` as secretName