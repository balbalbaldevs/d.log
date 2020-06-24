import React, { useEffect, useState, forwardRef, useRef } from 'react';
import { string, number, bool, func } from 'prop-types';
import classNames from 'classnames';
import './Textarea.scss';

const Textarea = forwardRef((props, ref) => {
  const { autoFocus = false, placeholder, name, className, disabled = false, onChange, maxLength } = props;
  const [value, setValue] = useState('');
  const [countValue, setCountValue] = useState(0);

  const textareaRef = useRef(null);

  const handleChange = (e) => {
    setValue(e.target.value);
    if (onChange) {
      onChange(e.target.value);
    }
    handleCount(e.target.value);
  };

  const handleCount = (value) => {
    if (value.length > maxLength) {
      return;
    }
    setCountValue(value.length);
  };

  useEffect(() => {
    if (textareaRef && textareaRef.current) {
      textareaRef.current.focus();
    }
  }, []);

  return (
    <div
      className={classNames('textarea', className)}
    >
      <textarea
        ref={autoFocus ? textareaRef : ref}
        className="textarea__area"
        name={name}
        placeholder={placeholder}
        value={value}
        maxLength={maxLength}
        onChange={handleChange}
        disabled={disabled}
      />

      {maxLength &&
        <p className="textarea__character">{countValue}/{maxLength}</p>
      }
    </div>
  );
});

Textarea.propTypes = {
  name: string,
  placeholder: string,
  size: number,
  maxLength: number,
  disabled: bool,
  onChange: func
};

export default Textarea;
