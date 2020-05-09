import React from 'react';
import { string } from 'prop-types';

// TODO 버튼 컴포넌트 작성
const Button = ({ text, ...rest }) => (
  <button {...rest} type="button">
    {text}
  </button>
);

Button.propTypes = {
  text: string.isRequired,
};

export default Button;
