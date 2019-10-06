import DateTimeFormat = Intl.DateTimeFormat;

interface Message {
  id: number;
  sender: number;
  receiver: number;
  time: DateTimeFormat;
  text: string;
}
