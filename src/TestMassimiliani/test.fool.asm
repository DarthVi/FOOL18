push 0
push 12
push function0
push 0
push function1
push function2
push 0
push 1
lfp
lfp
push -6
lfp
add
lw
js
push 1
add
halt

function0:
cfp
lra
push 2
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 3
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
lfp
lfp
lw
push -5
lfp
lw
add
lw
js
lfp
lfp
lw
push -3
lfp
lw
add
lw
js
add
srv
sra
pop
sfp
lrv
lra
js
