import React, { FC, forwardRef, useEffect, useRef, useState } from 'react';
import { Props } from './Input.types';
import { Input as AntdInput } from 'antd';

// TODO : ref 타입 다시 봐야함.
const Input = forwardRef<HTMLInputElement, Props>(({ autoFocus = false, onChange, ...rest }, ref: any) => {
  const localRef = useRef<HTMLInputElement | null>(null);
  const [value, setValue] = useState('');

  useEffect(() => {
    localRef.current && localRef.current.focus();
  }, []);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setValue(e.target.value);
    onChange && onChange(e);
  };

  return <AntdInput {...rest} ref={autoFocus ? localRef : ref} onChange={handleChange} />;
});

export default Input;
