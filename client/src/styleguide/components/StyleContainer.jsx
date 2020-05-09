import React from 'react';
import classNames from 'classnames';
import { oneOf } from 'prop-types';
import './StyleContainer.scss';

const StyleContainer = ({ direction = 'horizontal', posX = 'left', posY = 'top', ...rest }) => (
  <div
    {...rest}
    className={classNames('style-container', `position-${posX}-${posY}`, {
      column: direction === 'vertical',
    })}
  />
);

StyleContainer.propTypes = {
  direction: oneOf(['horizontal', 'vertical']),
  posX: oneOf(['left', 'right', 'center']),
  posY: oneOf(['top', 'bottom', 'center']),
};

export default StyleContainer;
