import PropTypes, { element, number, oneOf, oneOfType, string } from 'prop-types';
import { StylingAttrs } from '../../types/common.types';
import { COLORS } from '../../types/constants';

export const LOADING_TYPE = {
  SKELETON: 'skeleton',
  SPINNER: 'spinner',
  TEXT: 'text',
};

export const LoadingProps = {
  ...StylingAttrs,
  type: PropTypes.oneOf(Object.values(LOADING_TYPE)),
  children: oneOfType([element, string]),
  color: oneOf(Object.values(COLORS)),
  rows: number,
};
