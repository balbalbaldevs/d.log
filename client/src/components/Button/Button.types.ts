import React from 'react';

type AttributeProps = React.ButtonHTMLAttributes<HTMLButtonElement>;

type CustomProps = {
  theme?: 'primary' | 'secondary';
};

export type Props = AttributeProps & CustomProps;
