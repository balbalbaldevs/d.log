Default loading:

```js
import StyleContainer from '../../styleguide/components/StyleContainer';
<StyleContainer direction="horizontal" posY="center" style={{ justifyContent: 'space-between', width: 120 }}>
  <Loading size="small" />
  <Loading />
  <Loading size="large" />
</StyleContainer>
```

Skeleton loading:

```js
import React, { useEffect, useState } from 'react';
import sampleImage from '../../styleguide/assets/images/sample-image.jpg';
import StyleContainer from '../../styleguide/components/StyleContainer';
import { Button } from '../../components/';

const initialData = {
  title: null,
  text: null,
  imageUrl: null,
  author: null,
};

const mockData = {
  title: 'Skeleton Component',
  text: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
  imageUrl: sampleImage,
  author: {
    name: 'dog',
    imageUrl: sampleImage,
  }
};

const [load, setLoad] = useState(true);
const [data, setData] = useState(initialData);

const reset = () => {
  setData(initialData);
  setLoad(true);
}

const dataTimer = setTimeout(() => setData(mockData), 50000000); 

useEffect(() => {
  if (load) dataTimer;
  return () => clearTimeout(dataTimer);
}, [load]);

useEffect(() => {
  if (data) {
    clearTimeout(dataTimer);
    setLoad(false);
  }
}, [data]);

<StyleContainer>
  <Button style={{ marginBottom: 40 }} onClick={reset}>Reset</Button>
  <div style={{ width: '100%' }}>
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
  </div>
</StyleContainer>
``` 

Text loading:

```js
import StyleContainer from '../../styleguide/components/StyleContainer';

<StyleContainer posX="center" posY="center" style={{ justifyContent: 'space-between', height: 80 }}>
  <Loading type="text" size="small">Loading</Loading>
  <Loading type="text">Loading</Loading>
  <Loading type="text" size="large">Loading</Loading>
</StyleContainer>
```
