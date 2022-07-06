# Pre requisites
## Install Minikube
https://minikube.sigs.k8s.io/docs/start/

## Install Kubectl
https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/#install-kubectl-binary-with-curl-on-linux
and

## Install Istio
https://istio.io/latest/docs/setup/getting-started/#download

`kubectl apply -f samples/addons`

# Start up service
```
minikube start --memory=16384 --cpus=4
kubectl apply -f k8s/istio-test-service.yaml -f k8s/istio-test-gtw.yaml
```

## Test it
```
export INGRESS_HOST=$(minikube ip)
export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath=’{.spec.ports[?(@.name==”http2")].nodePort}’)
export GATEWAY=$INGRESS_HOST:$INGRESS_PORT
```

# Start up kaili dasboard
```
istioctl dashboard kiali

```
