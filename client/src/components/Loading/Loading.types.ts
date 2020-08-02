import React from 'react';
import { FontSizeType, SizeType } from '../../types';

export enum LOADING_TYPE {
  SKELETON = 'skeleton',
  SPINNER = 'spinner',
  TEXT = 'text',
}

type AttributesProps = React.HTMLAttributes<HTMLSpanElement>;

type CustomProps = {
  type?: 'skeleton' | 'spinner' | 'text';
  rowNum?: number;
  fontSize?: FontSizeType;
  size?: SizeType;
};

export type Props = AttributesProps & CustomProps;
