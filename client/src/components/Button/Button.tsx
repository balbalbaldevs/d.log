import React from 'react';
import { Props } from './Button.types';

// TODO 버튼 컴포넌트 작성
const Button: React.FC<Props> = ({ children, type = 'button', ...rest }) => (
  <button {...rest} type={type}>
    {children}
  </button>
);

export default Button;
