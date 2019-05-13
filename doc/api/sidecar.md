http://localhost:9200/health

http://localhost:9200/sujiakeji-config-server/sujiakeji-merchant-dev.yml

http://localhost:9200/hosts/sujiakeji-merchant

http://localhost:9200/sujiakeji-merchant/merchant/getById?id=1

```
curl -v -G 'http://localhost:9200/sujiakeji-merchant/merchant/getById' \
  --data-urlencode 'id=1'
```
