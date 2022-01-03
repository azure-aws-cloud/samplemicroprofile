# MicroProfile generated Applications

cd service-a

## Docker build
```
cd service-a

minikube start --driver=docker
minikube -p minikube docker-driver
eval$(minikube -p docker-driver)

docker build -t samplemicroprofile:latest .

kubectl create secret generic database-config --from-literal=database-server=10.0.1.15 --from-literal=user=rhushi --from-literal=password=123

kubectl apply -f deployment.yaml

Wait for 5 seconds for the container to go live and then run the below command

kubectl port-forward deployment.apps/payara-sample-deployment 8080:8080 4848:4848



```

## Edit secrets

```

To edit the secret and modify the value, run the command

echo -n "Rhushikesh123456897" | base64  
copy the returned base64 encoded value

run the command to edit the secret, the secret is opened in vi editor, paste the 
base64 encoded returned by above echo command, type :wq and save  
kubectl edit secrets database-config

```

## Re Deployment After modifying secret
```
After modifying the secret, run the commands.
kubectl delete all --all   (this does not delete the secret)

kubectl apply -f deployment.yaml

kubectl port-forward deployment.apps/payara-sample-deployment 8080:8080 4848:4848

```
## Test the application
```

http://localhost:8080/samplemicroprofile/data/hello
Output : Hello World for rhushi (this value rhushi is pushed by secret into container)

```