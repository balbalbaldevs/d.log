import React from 'react';
import { render } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';

import Home from './Home';

test('renders d.log text', () => {
  const { getByText } = render(<Home />);
  const logo = getByText(/d.log/i);

  expect(logo).toBeInTheDocument();
});
