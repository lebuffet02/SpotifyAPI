<h1 align="center">
  Consumindo API do Spotify
</h1>

- Gerando o Bearer Token do Spotify:
---
Substitua os valores no "client_id", "client_secret" e no "grant_type" pelas suas configs geradas dentro
da API do Spotify.

```
curl --location 'http://localhost:8080/api/v1/token' \
--header 'Content-Type: application/json' \
--data '{
    "client_id": "",
    "client_secret": "",
    "grant_type": ""
}'
```

- Executando Endpoint Novas Releases:
---

1. Clique em Authorization;
2. Em "Auth Type" selecione "Bearer Token";
3. Substitua "adicione o token aqui" para o seu token gerado anteriormente;
4. Em Params, altere os valores de "limit" e "offset" para diferentes responses;

```
curl --location 'http://localhost:8080/api/v1/albums/releases?limit=1&offset=1' \
--header 'Authorization: Bearer adicione token aqui' \
--data ''
```

<h1 align="center">
  Novas Features que eu criei para o Spotify:
</h1>


- Endpoint países disponíveis:
---
Nessa nova feature que eu criei, eu disponibilizo todos os países em ordem alfabética que 
receberam pelo menos um álbum do novo lançamento disponibilizado pelo Spotify.

```
curl --location 'http://localhost:8080/api/v1/albums/releases/availables?limit=7&offset=2'
```

- Endpoint álbuns disponíveis por países:
---
Nessa nova feature que eu também criei, eu disponibilizo cada novo álbum lançado, os dados do artista e junto a isso, os países que receberam este novo lançamento listados
em ordem alfabética.

```
curl --location 'http://localhost:8080/api/v1/albums/releases/availables/by-countries?limit=7&offset=2'
```