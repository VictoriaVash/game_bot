require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Молви, друг, и войди.
        
    state: NoMatch
        event!: noMatch
        a: Перефразируйте текст, ничего не понятно.

