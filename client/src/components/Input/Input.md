Input example:

```jsx
import React, { useState, useRef } from 'react';
import { Input } from '../../components/';
const inputRef = useRef(null);
const [value, setValue] = useState('');
const handleChange = (e) => {
  setValue(e.target.value);
};

<Input ref={inputRef} type="text" onChange={handleChange} />;
```

Property Refference: [Ant Design Input](https://ant.design/components/input/#Input)
