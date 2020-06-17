import React, { forwardRef, useEffect, useRef, useState } from 'react';
import { Input as AntdInput } from 'antd';

const Input = forwardRef(({ref, autoFocus = false , onChange, ...rest }) => {
    const localRef = useRef(null);
    const [value, setValue] = useState('');

    useEffect(() => {
        localRef.current && localRef.current.focus();
    }, []);

    const handleChange = e => {
        setValue(e.target.value);
        onChange && onChange(e.target.value);
    };

    return <AntdInput ref={autoFocus ? localRef : ref} onChange={handleChange} {...rest} />;
});
export default Input;
