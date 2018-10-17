push 0
push function2
push 5
push 1
push classA
new
lfp
push -3
lfp
add
lw
push 7
push 2
lfp
push -2
lfp
add
lw
js
halt

function0:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
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
push 2
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
push 1
lfp
add
lw
push 2
lfp
add
lw
lfp
push 3
lfp
add
lw
copy
lw
push 0
add
lc
js
add
add
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js
classA:
function0
function1
classnull:
