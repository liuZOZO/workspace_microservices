

This project is ticket seller application in microservice architecture, including 30+ microservices

java，spring boot，spring cloud

nodejs，express

python，dijango

go，webgo



------------------------------------------------------------------

1. local runtime environment

build:

mvn build：

mvn -Dmaven.test.skip=true clean package

docker-compose -f docker-compose.yml build


docker build:

docker-compose build
（docker-compose -f docker-compose.yml build）

docker-compose up -d

docker-compose down



start the ticket microservice applciation (single node):

docker-compose -f docker-compose.yml up -d

docker-compose down

docker-compose logs -f




------------------------------------------------------------------

2. clustering runtime environment（docker swarm）:

build:

mvn clean package

docker-compose build

docker-compose up

docker swarm init --advertise-addr 10.141.211.161

docker swarm join-token manager

docker swarm join-token worker



app tag:

docker tag ts/ts-ui-dashboard 10.141.212.25:5555/cluster-ts-ui-dashboard

......


app local registry：

docker push 10.141.212.25:5555/cluster-ts-ui-dashboard

......



deploy app （docker swarm）：

docker stack deploy --compose-file=docker-compose-swarm.yml my-compose-swarm



monitoring:

docker run -d -p 9000:9000 --name=portainer-ui-local -v /var/run/docker.sock:/var/run/docker.sock portainer/portainer

http://10.141.211.161:9000




----------------------------------------------------------------

3. Fault Replication Branches list (11): You can check the fault replication details on following branches of this git repository






