import React from 'react';
import classNames from 'classnames';
import { string, number } from 'prop-types';
import './Icon.scss';

const Icon = ({ className, name, size }) => (
  <i className={classNames('icon', `icon-${name}`, `icon-size-${size}`, className)}>
    <img src={`src/assets/icons/${name}.svg`} alt={name} />
  </i>
);

Icon.propTypes = {
  name: string.isRequired,
  className: string,
  size: number,
};

export default Icon;
