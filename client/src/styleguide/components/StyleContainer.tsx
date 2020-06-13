import React from 'react';
import classNames from 'classnames';
import './StyleContainer.scss';
import { DirectionType, PosXType, PosYType } from '../../types/ui.types';

type AttributeProps = React.HTMLAttributes<HTMLDivElement>;

type Props = AttributeProps & {
  direction: DirectionType;
  posX: PosXType;
  posY: PosYType;
};

const StyleContainer: React.FC<Props> = ({ direction = 'horizontal', posX = 'left', posY = 'top', ...rest }) => (
  <div
    {...rest}
    className={classNames('style-container', `position-${posX}-${posY}`, {
      column: direction === 'horizontal',
    })}
  />
);

export default StyleContainer;
