import { oneOf } from 'prop-types';
import { DIRECTION, POSX, POSY } from './constants';

export const Direction = oneOf([DIRECTION.HORIZONTAL, DIRECTION.VERTICAL]);

export const Position = {
  posX: oneOf([POSX.LEFT, POSX.RIGHT, POSX.CENTER]),
  posY: oneOf([POSY.TOP, POSY.BOTTOM, POSY.CENTER]),
};
