Default loading:

```js
<Loading />
```

Skeleton loading:

```js
const data = {
  title: null,
  text: null,
  image: null,
};

<>
  <Loading type="skeleton" />
  <h2>{data.title || <Loading type="skeleton" />}</h2>
  <p>{data.image}</p>
</>;
```

Text loading:

```js
<Loading type="text">Loading</Loading>
```
