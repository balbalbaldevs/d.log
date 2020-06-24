Select example:
```jsx
import React, { useState } from 'react';
import { Select } from '../index'; //component path
const optionData = [
    {value: '001', text: 'option001'},
    {value: '002', text: 'option001'},
    {value: '003', text: 'option001'},
];
const [value, setValue] = useState('001');
<Select data={optionData} value={value} />
```

Property Refference: [Ant Design Select](https://ant.design/components/select/#Select-props)