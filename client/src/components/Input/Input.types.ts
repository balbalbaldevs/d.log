import { InputProps as AntInputProps } from 'antd/lib/input';

export type CustomProps = {
  // ref: React.RefObject<HTMLInputElement>;
  onChange: (e: React.ChangeEvent<HTMLInputElement | string>) => void;
  autoFocus?: boolean;
};

export type InputProps = Omit<AntInputProps, 'onChange'>;
export type Props = InputProps & CustomProps;
