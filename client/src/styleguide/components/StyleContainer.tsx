import 'antd/dist/antd.css';
import './StyleContainer.scss';
import { DIRECTION } from '@/types/enums';

import classNames from 'classnames';
import React from 'react';

import { DirectionType, PosXType, PosYType } from '@/types/ui.types';

type AttributeProps = React.HTMLAttributes<HTMLDivElement>;

type Props = AttributeProps & {
  direction: DirectionType;
  posX: PosXType;
  posY: PosYType;
};

const StyleContainer: React.FC<Props> = ({ direction = 'vertical', posX = 'left', posY = 'top', ...rest }) => (
  <div
    {...rest}
    className={classNames('style-container', `position-${posX}-${posY}`, {
      column: direction === DIRECTION.VERTICAL,
    })}
  />
);

export default StyleContainer;
