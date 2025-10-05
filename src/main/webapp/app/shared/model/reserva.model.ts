import dayjs from 'dayjs';
import { IAsiento } from 'app/shared/model/asiento.model';
import { IPasajero } from 'app/shared/model/pasajero.model';
import { IVuelo } from 'app/shared/model/vuelo.model';

export interface IReserva {
  id?: number;
  codigo?: string;
  fechaReserva?: dayjs.Dayjs;
  estado?: string;
  asiento?: IAsiento | null;
  pasajero?: IPasajero | null;
  vuelo?: IVuelo | null;
}

export const defaultValue: Readonly<IReserva> = {};
