
FROM mysql:8.3

WORKDIR /tmp

COPY ./world.sql /docker-entrypoint-initdb.d

ENV MYSQL_ROOT_PASSWORD=rootpassword
ENV MYSQL_DATABASE=world
ENV MYSQL_USER user
ENV MYSQL_PASSWORD password

EXPOSE 3306