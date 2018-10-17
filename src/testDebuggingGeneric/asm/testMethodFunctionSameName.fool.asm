push 0
push function2
push 0
push classA
new
lfp
push 4
lfp
push -2
lfp
add
lw
js
print
lfp
push -3
lfp
add
lw
copy
lw
push 1
add
lc
js
print
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
lfp
push 6
lfp
push 1
lfp
add
lw
js
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
srv
sra
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
