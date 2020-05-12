import React from 'react';
import classNames from 'classnames';
import './StyleContainer.scss';
import { DIRECTION } from '../../types/constants';
import * as type from '../../types';

const StyleContainer = ({ direction = 'horizontal', posX = 'left', posY = 'top', ...rest }) => (
  <div
    {...rest}
    className={classNames('style-container', `position-${posX}-${posY}`, {
      column: direction === DIRECTION.VERTICAL,
    })}
  />
);

StyleContainer.propTypes = {
  direction: type.Direction,
  posX: type.Position.posX,
  posY: type.Position.posY,
};

export default StyleContainer;
