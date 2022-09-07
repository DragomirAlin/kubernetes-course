# ETCD 
`etcd` is a strongly consistent, distributed key-value store that provides a reliable way to store data that needs to be accessed by a distributed system or cluster of machines. It gracefully handles leader elections during network partitions and can tolerate machine failure, even in the leader node.

```bash
etcdctl --help
```

```bash
 ETCDCTL_API=3
 ETCDCTL_CERT=/etc/ssl/etcd/ssl/admin-node1.pem
 ETCDCTL_KEY=/etc/ssl/etcd/ssl/admin-node1-key.pem
 ETCDCTL_CACERT=/etc/ssl/etcd/ssl/ca.pem
```

### Create a snapshot
```bash
ETCDCTL_API=3 etcdctl snapshot save snapshot.db \
   --cacert /etc/ssl/etcd/ssl/ca.pem \
   --cert /etc/ssl/etcd/ssl/admin-node1.pem \
   --key /etc/ssl/etcd/ssl/admin-node1-key.pem
```

### Status snapshot
```bash
ETCDCTL_API=3 etcdctl snapshot status snapshot.db \
   --cacert /etc/ssl/etcd/ssl/ca.pem \
   --cert /etc/ssl/etcd/ssl/admin-node1.pem \
   --key /etc/ssl/etcd/ssl/admin-node1-key.pem
```