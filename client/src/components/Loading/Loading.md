Default loading:

```js
<Loading />
```

Skeleton loading:

```js
import React from 'react';
import sampleImage from '../../styleguide/assets/images/sample-image.jpg';

const mockData = {
  title: 'Skeleton Component',
  text: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
  imageUrl: sampleImage,
  author: {
    name: 'dog',
    imageUrl: sampleImage,
  }
};

const [data, setData] = React.useState({
  title: null,
  text: null,
  imageUrl: null,
  author: null,
});

React.useEffect(() => {
  const dataTimer = setTimeout(() => setData(mockData), 10000); 
  return () => clearTimeout(dataTimer);
}, []);

<>
  <div style={{ width: 40, height: 40, borderRadius: '50%', overflow: 'hidden' }}>
    {data.author != null ? 
      <img src={data.author.imageUrl} alt={data.author.name} style={{ width: '100%', height: '100%' }} /> : 
      <Loading type="skeleton" />}
  </div>
  <h2>{data.title || <Loading type="skeleton" style={{ width: 200, height: 24 }} />}</h2>
  <p>{data.text || <Loading type="skeleton" rowNum={4} />}</p>
  {data.imageUrl ? 
    <img src={data.imageUrl} style={{ width: 200 }} alt="" /> : 
    <Loading type="skeleton" style={{ width: 200, height: 150 }} />}
</>; 
```

Text loading:

```js
<Loading type="text">Loading</Loading>
```
