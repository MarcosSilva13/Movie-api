# Api de filmes e categorias
<p>
  A API permite a criação, recuperação, atualização e exclusão de informações sobre filmes e categorias.
  Para filmes, a API mantém um registro do ID, nome e ano de lançamento. 
  Para categorias, a API mantém um registro do ID e do nome da categoria.
</p>

+ OBS: Ainda em construção...

<h2> Tecnologias utilizadas </h2>
<p>
  🔹<strong> Java 11 </strong> <br>
  🔹<strong> Spring Boot </strong> <br>
  🔹<strong> H2 database </strong> <br>
  🔹<strong> JPA & Hibernate </strong> <br>
  🔹<strong> Maven </strong><br>
</p>

<h2> Endpoints - Filme </h2>

<h3>🔹GET🔹</h3>

```bash
/movies ==> (Retorna a lista de todos os filmes).

/movies/sortByName ==> (Retorna a lista de todos os filmes ordenados por nome).

/movies/{id} ==> (Retorna um filme pelo id).

/movies/name/{name} ==> (Retorna um filme pelo nome).
```
<h3>🔹POST🔹</h3>

```bash
/movies/save ==> (Salva um novo filme).
```
<h3>🔹PUT🔹</h3>

```bash
/movies/update ==> (Atualiza os dados de um filme).
```
<h3>🔹DELETE🔹</h3>

```bash
/movies/delete/{id} ==> (Deleta um filme pelo id).
```

<h2> Endpoints - Categoria </h2>

<h3>🔹GET🔹</h3>

```bash
/categories ==> (Retorna a lista de categorias).

/categories/{id} ==> (Retorna uma categoria pelo id).
```
<h3>🔹POST🔹</h3>

```bash
/categories/save ==> (Salva uma nova categoria).
```
<h3>🔹PUT🔹</h3>

```bash
/categories/update ==> (Atualiza os dados de uma categoria).
```
<h3>🔹DELETE🔹</h3>

```bash
/categories/delete/{id} ==> (Deleta uma categoria pelo id).
```

<h3>Exemplo de retorno de um filme </h3>

```bash
{
  "id": 1,
  "name": "Fast and Furious",
  "releaseYear": 2001,
  "Category": {
      "id": 1,
      "name": "Action"
  }
}
```
<h3>Exemplo de retorno de uma categoria </h3>

```bash
{
    "id": 1,
    "name": "Action"
}
```
