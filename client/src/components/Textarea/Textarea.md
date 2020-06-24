Textarea example:

```js
import React from 'react';
const [text, setText] = React.useState('');
const handleChange = (newValue) => {
  setText(newValue);
};

<>
  <Textarea onChange={handleChange} maxLength={200}/>
</>;
```

Ref로 textarea 제어법:

```js
import React, {useRef} from 'react';
const textareaRef = useRef(null);
const handleClick = () => {
  textareaRef.current.focus();
}

<>
  <button onClick={handleClick} style={{marginBottom: 10}}>클릭</button>

  <Textarea ref={textareaRef} />
</>
```

autoFocus:

```js
<>
  <Textarea autoFocus={true} />
</>
```
