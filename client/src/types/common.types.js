import { number, objectOf, oneOfType, string } from 'prop-types';

export const StylingAttrs = {
  className: string,
  style: objectOf(oneOfType([string, number])),
};
