#!/bin/bash
REDISPORT=6379

REDISPATH=/home/apps/redis-5.0.8/src
EXEC=${REDISPATH}/redis-server
CLIEXEC=${REDISPATH}/redis-cli
PIDFILE=/var/run/redis_${REDISPORT}.pid
CONF=/home/apps/redis-5.0.8/redis.conf

case "$1" in
  start)
    if [ -f $PIDFILE ]
    then
      echo "$PIDFILE exists, process is already running or crashed."
    else
      echo "starting redis server..."
      $EXEC $CONF
    fi
    ;;
  stop)
    if [ ! -f $PIDFILE ]
    then
      echo "$PIDFILE does not exist, process is not running"
    else
      PID=$(cat $PIDFILE)
      echo "stoping..."
      $CLIEXEC -p $REDISPORT shutdown
      while [ -x /proc/${PID} ]
      do
        echo "wating for redis to shutdown..."
        sleep 1
      done
      echo "redis stopped"
    fi
    ;;
  *)
    echo "please use start or stop as first argument"
    ;;
esac
