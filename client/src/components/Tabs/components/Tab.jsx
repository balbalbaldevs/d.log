import React from 'react';
import Icon from '../../Icon/Icon';
import classNames from 'classnames';
import { string, number } from 'prop-types';

const Tab = ({ name, className, iconName, iconPlacement, iconSize }) => {
  return <span className={classNames('tab', `is-${iconPlacement}`, className)} >
    {iconName && <Icon name={iconName} size={iconSize} />}
    {name}
  </span>
};

Tab.propTypes = {
  name: string.isRequired,
  className: string,
  iconName: string,
  iconPlacement: string,
  iconSize: number,
};

export default Tab;